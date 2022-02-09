package com.example.app.bbs.config

import com.example.app.bbs.app.service.UserDetailsServiceImpl
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
  lateinit var userDetailsService: UserDetailsServiceImpl

  @Bean
  fun passwordEncoder(): PasswordEncoder {
    return BCryptPasswordEncoder()
  }

  @Override
  override fun configure(auth: AuthenticationManagerBuilder) {
    auth.userDetailsService(userDetailsService)
  }

}
