(set-env!
  :dependencies '[[adzerk/boot-cljs          "1.7.48-6"]
                  [adzerk/boot-reload        "0.4.1"]
                  [hoplon/boot-hoplon        "0.1.10"]
                  [hoplon/hoplon             "6.0.0-alpha10"]
                  [hoplon/castra             "3.0.0-SNAPSHOT"]
                  [compojure                 "1.4.0"]
                  [korma                     "0.4.0"]
                  [org.xerial/sqlite-jdbc    "3.7.15-M1"]
                  [org.clojure/clojure       "1.7.0"]
                  [org.clojure/clojurescript "1.7.145"]
                  [pandeiro/boot-http        "0.6.3"]
                  [ring                      "1.4.0"]
                  [ring/ring-defaults        "0.1.5"]]

  :source-paths #{"src"}
  :asset-paths  #{"assets"})

(require
  '[adzerk.boot-cljs         :refer [cljs]]
  '[adzerk.boot-reload       :refer [reload]]
  '[hoplon.boot-hoplon       :refer [hoplon prerender]]
  '[pandeiro.boot-http       :refer [serve]])

(deftask dev
  "Build crud-user-test for local development."
  []
  (comp
    (serve
      :handler 'router.core/router
      :reload true
      :port 8000)
    (watch)
    (speak)
    (hoplon)
    (reload)
    (cljs)))

(deftask prod
  "Build crud-user-test for production deployment."
  []
  (comp
    (hoplon)
    (cljs :optimizations :advanced)
    (prerender)))
