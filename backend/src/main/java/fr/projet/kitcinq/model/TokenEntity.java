package fr.projet.kitcinq.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "token")
public class TokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Relation OneToOne avec UserEntity
    @OneToOne
    @JoinColumn(name = "users_id", nullable = false, unique = true) // Foreign key 'users_id' dans la table 'token'
    private UserEntity user;

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenId=" + tokenId +
                ", token='" + token + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user.getId() +
                '}';
    }
}
