package net.javaguides.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students_corran")
public class students_coraan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private int age;
    private String adresse;


    @Enumerated(EnumType.STRING)
    private NiveauCoran niveau;

    // Si partiel — préciser les sourates mémorisées
    private String sourateDe;
    private String sourateA;

    // Coordonnées

    private String email;
    private String telephone;

    // Coordonnées des parents (si < 15 ans)
    private String parentNom;
    private String parentEmail;
    private String parentTelephone;
    private String password; // mot de passe pour login
    private String role = "STUDENT"; // par défaut, l’admin reste ADMIN

    public String getPassword() {
        return password;
    }
    public students_coraan() {
        // constructeur par défaut requis par JPA / Hibernate
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public students_coraan(String password) {
        this.password = password;
    }

    // --- Getters & Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public NiveauCoran getNiveau() { return niveau; }
    public void setNiveau(NiveauCoran niveau) { this.niveau = niveau; }

    public String getSourateDe() { return sourateDe; }
    public void setSourateDe(String sourateDe) { this.sourateDe = sourateDe; }

    public String getSourateA() { return sourateA; }
    public void setSourateA(String sourateA) { this.sourateA = sourateA; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getParentNom() { return parentNom; }
    public void setParentNom(String parentNom) { this.parentNom = parentNom; }

    public String getParentEmail() { return parentEmail; }
    public void setParentEmail(String parentEmail) { this.parentEmail = parentEmail; }

    public String getParentTelephone() { return parentTelephone; }
    public void setParentTelephone(String parentTelephone) { this.parentTelephone = parentTelephone; }

    @Transient
    public boolean isMineur() {
        return this.age < 15;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

