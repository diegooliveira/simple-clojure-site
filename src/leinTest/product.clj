(ns leinTest.product
	(:use 
		[org.httpkit.server]
		[hiccup.core]
		[compojure.core :only [defroutes GET POST ANY]]))
	

;; Doing the list product
(defn list_products [request]
	(html [:span {:class "foo"} "bar"]))

;; Saving the product
(defn save_products [request]
	"save products")

; Defining the product routes
(defroutes product-routes
	(GET  "/list" [] list_products)
	(POST "/save" [] save_products))