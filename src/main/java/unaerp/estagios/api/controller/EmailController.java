package unaerp.estagios.api.controller;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import unaerp.estagios.api.usuarios.UsuarioRepository;
import unaerp.estagios.api.usuarios.Usuario;

@RestController
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UsuarioRepository usuarioRepository;



    @RequestMapping(path = "/email-send", method = RequestMethod.POST)
    public String sendMail(@RequestBody String email) {

        Usuario usuario;

        try {
            usuario = usuarioRepository.findByEmail(email);
        } catch (Exception e){
            throw new RuntimeException("Usuário não encontrado com o email: " + email);
        }

        if(usuario == null) {
            return "Usuário não encontrado com o email: " + email;
        }

        String emailContent = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>Email de Recuperação de Senha</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f4f4f4;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 0 auto;\n" +
                "            background-color: #fff;\n" +
                "            padding: 20px;\n" +
                "            border-radius: 5px;\n" +
                "            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "\n" +
                "        h1 {\n" +
                "            font-size: 24px;\n" +
                "            margin-bottom: 20px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "\n" +
                "        p {\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .password {\n" +
                "            font-weight: bold;\n" +
                "            color: #007bff;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <h1>Email de Recuperação de Senha</h1>\n" +
                "        <p>Olá,<strong> "+ usuario.getNome() +"</strong> aqui está sua senha:</p>\n" +
                "        <p><strong>Sua senha: <span class=\"password\">" + usuario.getSenha() + "</span></strong></p>\n" +
                "        <p>\n" +
                "            Se você tiver alguma dúvida ou precisar de mais informações, por favor, entre em contato conosco.\n" +
                "        </p>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";


        try {
            MimeMessage mail = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setTo(usuario.getEmail());
            helper.setSubject("Email de Recuperação de Senha");
            helper.setText(emailContent, true);

            mailSender.send(mail);

            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
}
