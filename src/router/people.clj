(ns router.people
  (:require [models.db :refer :all]
            [ring.util.response :as response]))

(defn get-all
  (response/content-type
    (response/resource-response "people.html")
    "text/html"))
