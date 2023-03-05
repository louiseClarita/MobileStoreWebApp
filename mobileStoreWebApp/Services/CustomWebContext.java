import org.thymeleaf.context.IContext;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

public class CustomWebContext implements IWebContext {

    private final WebContext webContext;

    public CustomWebContext(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        this.webContext = new WebContext(request, response, request.getServletContext(), locale, null);
    }

    @Override
    public HttpServletRequest getRequest() {
        return webContext.getRequest();
    }

    @Override
    public HttpServletResponse getResponse() {
        return webContext.getResponse();
    }

    @Override
    public HttpSession getSession() {
        return webContext.getSession();
    }

    @Override
    public Map<String, Object> getSessionAttributes() {
        return webContext.getSessionAttributes();
    }

    @Override
    public Object getSessionAttribute(String name) {
        return webContext.getSessionAttribute(name);
    }

    @Override
    public void setSessionAttribute(String name, Object value) {
        webContext.setSessionAttribute(name, value);
    }

    @Override
    public Locale getLocale() {
        return webContext.getLocale();
    }

    @Override
    public void setVariable(String name, Object value) {
        webContext.setVariable(name, value);
    }

    @Override
    public void setVariables(Map<String, Object> variables) {
        webContext.setVariables(variables);
    }

    @Override
    public boolean containsVariable(String name) {
        return webContext.containsVariable(name);
    }

    @Override
    public Map<String, Object> getVariables() {
        return webContext.getVariables();
    }

    @Override
    public Object getVariable(String name) {
        return webContext.getVariable(name);
    }

    @Override
    public IContext setSelectionTarget(Object selectionTarget) {
        return webContext.setSelectionTarget(selectionTarget);
    }

    @Override
    public Object getSelectionTarget() {
        return webContext.getSelectionTarget();
    }
}
