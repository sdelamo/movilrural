import org.springframework.web.servlet.i18n.SessionLocaleResolver
import com.softamo.movilrural.UserPasswordEncoderListener
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    localeResolver(SessionLocaleResolver) {
        defaultLocale= new java.util.Locale('es');
    }
}