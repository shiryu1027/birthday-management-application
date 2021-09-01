package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
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
			.antMatchers("/admin/admin").hasAuthority("ROLE_ADMIN") // 権限制御
			.anyRequest().authenticated(); // それ以外は直リンクNG
		
		// サインイン処理
		http.formLogin()
			.loginProcessingUrl("/users/signin") // サインイン処理のパス
			.loginPage("/users/signin") // サインインぺージの指定
			.failureUrl("/users/signin?error") // サインイン失敗時の遷移先
			.usernameParameter("mailAddress") // サインインページのユーザーID(流すDtoのフィールド名)
			.passwordParameter("password") // サインインぺージのパスワード
			.defaultSuccessUrl("/birthdayManagement/home", true); //成功後の遷移先)
		
		// サインアウト処理(コントローラーはSpringセキュリティがやってくれる) → ただし、htmlには遷移先を記載する
		http
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/users/signout")) //　GETメソッドでログアウトのリクエストを送る場合付ける
				.logoutUrl("/users/signout") // ログアウトのリクエスト先パス
				.logoutSuccessUrl("/users/signin?signout"); // ログアウト成功時の遷移先を指定
		
		//http.csrf().disable(); // CSRF対策を一時的に無効(後に削除?)
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	PasswordEncoder encoder = passwordEncoder();
    	
        // インメモリ認証 (パスワードの暗号化ができていないと、ログインできない)
        auth
            .inMemoryAuthentication()
                .withUser("admin@co.jp") // userを追加
                    .password(encoder.encode("admin"))
                    .roles("ADMIN") // ROLE_はなしでいい
        		.and()
        		.withUser("user@co.jp") // userを追加
	                .password(encoder.encode("user"))
	                .roles("GENERAL");
        
        // ユーザーデータで認証
        auth
        	.userDetailsService(userDetailsService)
        	.passwordEncoder(encoder);
        
    }
	
}