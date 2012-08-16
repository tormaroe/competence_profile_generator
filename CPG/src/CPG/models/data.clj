(ns CPG.models.data
  (:require [monger.core :as mg])
  (:require [monger.collection :as mc]))

(def collection "data")

(defn key [item]
  (:_id item))

(defn value [item]
  (:value item))

(defn save [id value]
  (mc/update collection
             {:_id id} 
             {:_id id :value value} 
             :upsert true))

(defn delete [id]
  (mc/remove collection {:_id id}))

(defn get-all []
  (mc/find-maps collection))
