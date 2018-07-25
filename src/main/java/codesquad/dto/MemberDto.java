package codesquad.dto;


import codesquad.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class MemberDto {
    @NotBlank(message = "메일을 작성해주세요.")
    @Email(message = "메일의 양식을 지켜주세요.")
    private String email;
    @NotBlank(message = "비밀번호를 입력하세요")
    @Size(min = 4, max = 30, message = "비밀번호는 4자리 이상, 30자 이하이어야 합니다.")
    private String password;
    @NotBlank(message = "이름을 입력하세요")
    @Size(max = 30, message = "이름은 30자 이하이어야 합니다.")
    private String username;
    @NotBlank(message = "전화번호를 작성해주세요.")
    @Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자만 입력가능합니다")
    private String phoneNumber;

    public MemberDto() {

    }
    public MemberDto(MemberDto member) {
        this(member.getEmail(), member.getPassword(), member.getUsername(), member.getPhoneNumber());
    }

    public Member toEntity() {
        //TODO: password encryption should be added
        return new Member(email, password, username, phoneNumber);
    }

    public static MemberDto defaultMemberDto() {
        return new MemberDto("pobi@naver.com", "1234", "pobi", "01012341234");
    }

    public MemberDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public MemberDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public MemberDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public MemberDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
