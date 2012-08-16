(ns CPG.server
  (:require [noir.server :as server])
  (:require [monger.core :as mg]))

(mg/connect!)
(mg/set-db! (mg/get-db "competence"))

(server/load-views-ns 'CPG.views)

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'CPG})))

