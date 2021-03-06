package com.example.app.bbs.domain.entity

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name="users")
data class User (
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Int = 0,
  @field:NotBlank
  @field:Size(min=4,max=16)
  var name: String = "",
  @field:NotBlank
  @field:Email
  var email: String = "",
  var password: String = "",
  var role: Int = 0
)