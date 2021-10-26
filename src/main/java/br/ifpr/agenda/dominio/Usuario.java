package br.ifpr.agenda.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String password;

    private String role;

    @Override
    public String toString() {
        return "Usuario [nome=" + name + ", email=" + username + ", password="
                + password + "]";
    }
    public boolean isVazio() {
        return !StringUtils.hasText(name)
                &&
                !StringUtils.hasText(username)
                &&
                !StringUtils.hasText(password);
    }
}
