import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.collect.Lists;
import com.twilio.jwt.client.ClientCapability;
import com.twilio.jwt.client.IncomingClientScope;
import com.twilio.jwt.client.Scope;

public class TwilioServlet extends HttpServlet {

  // Get your Account SID and Auth Token from https://twilio.com/console
  // To set up environment variables, see http://twil.io/secure
  public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
  public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

  public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<Scope> scopes = Lists.newArrayList(new IncomingClientScope("joey"));

    ClientCapability capability = new ClientCapability.Builder(ACCOUNT_SID, AUTH_TOKEN)
      .scopes(scopes)
      .build();

    String token = capability.toJwt();

    response.setContentType("application/jwt");
    response.getWriter().print(token);
  }
}
