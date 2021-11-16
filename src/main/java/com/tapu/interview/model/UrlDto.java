package com.tapu.interview.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UrlDto
{
    private String url;
    private String expirationDate;
    private List<User> userList;
    private User user;
}
