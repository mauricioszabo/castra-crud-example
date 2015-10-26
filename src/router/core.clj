(ns router.core
;   (:require [castra.middleware :as castra]
;             [compojure.core :as c]
;             [compojure.route :as route]
;             [ring.middleware.defaults :as d]
;             [ring.util.response :as response]))
;
; (c/defroutes app-routes
;   (c/GET "/" req (response/content-type (response/resource-response "index.html") "text/html"))
;   (c/GET "/people" req (response/content-type (response/resource-response "index.html") "text/html"))
;   (route/resources "/" {:root ""}))
;
; (def router
;   (-> app-routes
;       (castra/wrap-castra 'app.api)
;       (castra/wrap-castra-session "a 16-byte secret")
;       (d/wrap-defaults d/api-defaults)))
;
; (ns users-systems.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(use 'selmer.parser)

(defroutes app-routes
  (GET "/" [] (render-file "people.html" {}))

  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
