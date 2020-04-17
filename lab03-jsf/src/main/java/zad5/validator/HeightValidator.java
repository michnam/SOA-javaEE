package zad5.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("heightValidator")
public class HeightValidator implements Validator
{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException
    {
        Object genderObj = uiComponent.getAttributes().get("gender");
        if (genderObj != null)
        {
            int height = (int) o;
            String gender = genderObj.toString();

            if (gender.equals("Male") && (height < 165 || height > 200))
            {
                FacesMessage message = new FacesMessage("Not correct height", "Allowed height for men: 165 - 200 cm");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
            else if (gender.equals("Female") && (height < 150 || height > 185))
            {
                FacesMessage message = new FacesMessage("Not correct height", "Allowed height for women: 150 - 185 cm");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }


    }
}
