package com.whoosh_backend.Whoosh_Backend.api.dto.user;

    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import javax.validation.constraints.Email;
    import javax.validation.constraints.NotBlank;
    import javax.validation.constraints.NotNull;
    import javax.validation.constraints.Pattern;
    import javax.validation.constraints.Size;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public class UserDto {
        private int id;

        @NotBlank(message = "Username is mandatory")
        @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
        private String username;

        @NotBlank(message = "Password is mandatory")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        private String password;

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email should be valid")
        private String email;

        @NotBlank(message = "Phone number is mandatory")
        @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
        private String phoneNumber;

        @NotBlank(message = "Role is mandatory")
        private String role;

        @NotNull(message = "Address is mandatory")
        private String address;
    }