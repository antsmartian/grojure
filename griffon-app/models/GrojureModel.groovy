import groovy.beans.Bindable
import java.beans.PropertyChangeListener

class GrojureModel {
   @Bindable String input1
   @Bindable String input2
   @Bindable String output
   @Bindable boolean enabled = false

   GrojureModel() {
      addPropertyChangeListener({ e ->
         if( e.propertyName == "enabled" ) return
         if( input1 && input2 ) enabled = true
      } as PropertyChangeListener)
   }

}
