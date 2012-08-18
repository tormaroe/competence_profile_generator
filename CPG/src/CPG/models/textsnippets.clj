(ns CPG.models.textsnippets
  (:import [org.bson.types ObjectId]) 
  (:require [monger.collection :as mc]))

(def groups-collection "groups")
(def snippets-collection "snippets")

(comment
  "A snippet is a hash-map with this format:"
  { :_id   some-ObjectId
    :group "People, Cases, or something else..."
    :name  "to be displayed in manager, and sorted by. 
           Should be unique within a group."
    :text  "the text itself"
   ; optional ;
    :use-count 0 }
  )

(defn groups 
  "Yields a sequence of strings"
  []
  (->>
    (mc/find-maps groups-collection)
    (map :_id)
    sort))

(defn add-group [g]
  (mc/insert groups-collection {:_id g}))

(defn delete-group [g]
  (mc/remove groups-collection {:_id g}))

(defn get-snippets-by-group 
  "Retrieves a list of snippets in a group. Only :_id and :name."
  [group-key]
  (->>
    (mc/find-maps snippets-collection 
                  {:group group-key})
    (map #({:_id (:_id %), :name (:name %)}))
    (sort-by :name)))

(defn snippet 
  "id is expected to be a string representation of an ObjectId"
  [id]
  (mc/find-map-by-id snippets-collection 
                     (ObjectId. id)))

(defn save [snippet]
  (let [snippet (assoc snippet 
                       :_id (ObjectId. (:_id snippet)))]
    (mc/update snippets-collection
               {:_id (:_id snippet)}
               snippet
               :upsert true)))

(defn delete 
  "id is expected to be a string representation of an ObjectId"
  [id]
  (mc/remove snippets-collection 
             (ObjectId. id)))
