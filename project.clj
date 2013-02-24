(defproject leinTest "1.0.0-SNAPSHOT"
	:description "FIXME: write description"
	:plugins [[lein-ring "0.8.2"]]
  	:dependencies [
		[org.clojure/clojure "1.4.0"]
		[http-kit "2.0.0-RC4"]
		[compojure "1.1.5"]
		[liberator "0.8.0"]
		[enlive "1.1.1"]]
	;:main leinTest.core
	:ring {:handler leinTest.core/app})
