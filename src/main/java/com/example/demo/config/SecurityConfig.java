/*package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // 色々あるが、BCryptPasswordEncoderの使用が推奨
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// セキュリティの対処外
		web.ignoring()
			.antMatchers("/css/**")
			.antMatchers("/images/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		// サインイン不要ぺージの設定
		http.authorizeRequests()
			.antMatchers("/users/signup").permitAll() // 直リンクOK
			.antMatchers("/users/signin").permitAll() // 直リンクOK
			.antMatchers("/birthdayManagement/").permitAll() // Controllerのパスを指定
			.anyRequest().authenticated(); // それ以外は直リンクNG
		
		// サインイン処理
		http.formLogin()
			.loginProcessingUrl("/users/signin") // サインイン処理のパス
			.loginPage("/users/signin") // サインインぺージの指定
			.failureUrl("/users/signin?error") // サインイン失敗時の遷移先
			.usernameParameter("id") // サインインページのユーザーID
			.passwordParameter("password") // サインインぺージのパスワード
			.defaultSuccessUrl("/birthdayManagement/", true); //成功後の遷移先)
		
		http.csrf().disable(); // CSRF対策を一時的に無効(後に削除?)
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	PasswordEncoder encoder = passwordEncoder();
    	
        // インメモリ認証 (パスワードの暗号化ができていないと、ログインできない)
        auth
            .inMemoryAuthentication()
                .withUser("user@co.jp") // userを追加
                    .password(encoder.encode("user"))
                    .roles("ADMIN");
    }
	
}
*/