import com.jait.OptionRequestFilter
import com.jait.UserPasswordEncoderListener

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    optionRequestFilter(OptionRequestFilter)
}
