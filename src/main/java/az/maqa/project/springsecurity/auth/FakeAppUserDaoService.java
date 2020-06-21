package az.maqa.project.springsecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static az.maqa.project.springsecurity.enums.AppUserRole.*;

@Repository
public class FakeAppUserDaoService implements AppUserDao {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Optional<AppUser> selectAppUserByUsername(String username) {
		return getAppUsers().stream().filter(appUser -> username.equals(appUser.getUsername())).findFirst();
	}

	private List<AppUser> getAppUsers() {
		List<AppUser> appUserList = Lists.newArrayList(
				new AppUser(STUDENT.getGrantedAuthorities(), passwordEncoder.encode("123"), "samir", true, true, true,
						true),
				new AppUser(ADMIN.getGrantedAuthorities(), passwordEncoder.encode("123"), "arif", true, true, true,
						true),
				new AppUser(ADMINTRAINEE.getGrantedAuthorities(), passwordEncoder.encode("123"), "qasim", true, true,
						true, true)

		);

		return appUserList;
	}
}
