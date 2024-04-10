package br.com.cpsoftware.finance.model;

import java.io.Serializable;
import java.util.Objects;
import lombok.Data;

@Data
public class AuthorityId implements Serializable {
    private Long user;
    private String authority;

    public AuthorityId() {}

    public AuthorityId(Long user, String authority) {
        this.user = user;
        this.authority = authority;
    }

}
