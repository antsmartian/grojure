import clojure.lang.Compiler
import griffon.clojure.ClojureProxy

def cljproxy = new ClojureProxy()

onBootstrapEnd = { app ->
  new File(".").eachFileMatch({it.endsWith(".clj")}) { file ->
    file.withReader { reader -> Compiler.load reader }
    println " [clojure] loaded $file"
  }
}

onNewInstance = { klass, type, instance ->
  klass.metaClass.getClj = { return cljproxy }
}
