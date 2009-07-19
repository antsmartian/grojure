import net.miginfocom.swing.MigLayout

actions {
  action(id: "callClojureAction",
    name: "Clojure!",
    enabled: bind{ model.enabled },
    closure: controller.callClojure)
}

application(title:'grojure',
  size:[320,400], name: "frame",
  pack:true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
   panel(layout: new MigLayout("fill","[left]")) {
      label("Inputs", constraints: "split, span, gaptop 10")
      separator( constraints: "growx, wrap, gaptop 10")
      label("A:")
      textField(columns: 20, constraints: "wrap",
        text: bind(target: model, targetProperty: "input1"))
      label("B:")
      textField(columns: 20, constraints: "wrap",
        text: bind(target: model, targetProperty: "input2"))
      button(callClojureAction, constraints: "span, grow, wrap")

      label("Output", constraints: "split, span, gaptop 10") 
      separator( constraints: "growx, wrap, gaptop 10")
      textField(id: "output", columns: 20, constraints: "span, grow, wrap",
        text: bind{model.output}, editable: false)
   }
}
