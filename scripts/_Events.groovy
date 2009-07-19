import clojure.lang.Compiler

eventCopyLibsEnd = { jardir ->
   ant.copy(todir:jardir) { fileset(dir: "${basedir}/griffon-app/clj", includes: "*.clj") }
}
