(ns leinTest.core
	(:use 
		[compojure.route :only [files not-found]]
		[compojure.handler :only [site]] ; form, query params decode; cookie; session, etc
		[compojure.core :only [defroutes GET POST DELETE ANY context]]
		[hiccup.core]
		[net.cgrand.enlive-html]
		[compojure.route :only [resources]]
		[org.httpkit.server]
		[leinTest.product]))


(defn show-landing-page [req]
	;; ordinary clojure function, accept request map
	;; return landing page's html string. possible template library:
	;; mustache (https://github.com/shenfeng/mustache.clj, https://github.com/fhd/clostache...)
	;; enlive (https://github.com/cgrand/enlive),  hiccup(https://github.com/weavejester/hiccup)
	layout)


;; Defining the global rotes
(defroutes all-routes

	;; Mapping the home path.
	(GET "/" [] show-landing-page)
	
	;; Mapping the product routes comming from products.clj
	(context "/product" [] product-routes)

	;; Defining the resoource path, all files in resource/public may be accesible from this
	;; path in the browser.
	(resources "/static/"))

;; Defining the app that is exposed by lein ring plugin
(def app (site all-routes))

(defn -main []
	(run-server (site #'all-routes) {:port 8080}))


