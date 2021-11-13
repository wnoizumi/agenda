package br.ifpr.agenda.seguranca;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ifpr.agenda.dominio.Usuario;
import br.ifpr.agenda.repositories.UsuarioRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //username = email
        Usuario usuario = usuarioRepository.findByEmail(email);
       

        if (usuario != null){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(authority);
            User user = new User(usuario.getEmail(), usuario.getSenha(), authorities);
            return user;
        }
        
        return null;
    }
    
}
