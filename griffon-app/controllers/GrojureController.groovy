class GrojureController {
    def model
    def view

    def callClojure = { evt = null ->
        def a = model.input1 as BigDecimal
        def b = model.input2 as BigDecimal
        model.output = clj.add_numbers(a,b).toString()
    }
}
