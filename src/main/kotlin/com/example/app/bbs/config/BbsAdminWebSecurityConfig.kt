package com.example.app.bbs.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableWebSecurity
class BbsAdminWebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Override
    override fun configure(auth: AuthenticationManagerBuilder) {

        auth.inMemoryAuthentication()
            .withUser("admin")
            .password(
                "\$2a\$10\$qHwwgwxqm5Od7dSdeIE4wu3lhLbA3xicU3IwPGQWsCxBu13vit7FK" // "$"に関してコンパイルエラーが出る場合は、直前に"\"を足してエスケープしても問題ない
            )
            .authorities("ROLE_ADMIN")
    }
}
