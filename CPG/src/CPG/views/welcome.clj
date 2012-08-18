(ns CPG.views.welcome
  (:require [CPG.views.common :as common])
  (:require [CPG.models.textsnippets :as snippets])
  (:use [noir.core :only [defpage defpartial]]))


(defpartial splash []
  [:div.hero-unit
   [:h1 "Competence Profiles"]
   [:p "Manage your company competency profile with ease, 
       and generate targeted profiles like a boss!"]])

(def btn-large          :a.btn.btn-large.btn-info)
(def btn-large-group    :a.btn.btn-large.btn-success)
(def btn-large-primary  :a.btn.btn-large.btn-primary)

(defpartial element-80p [elm href & content]
  [elm {:href href :style "width:80%;margin-bottom:5px;"} content])

(defpartial column [& content]
  [:div.span4 {:style "text-align:center;"} content]) 

(defpartial snippet-groups-column []
  (->>
    (snippets/groups)
    (map (fn [g]
           (element-80p btn-large-group 
                        (str "snippetgroup/" g)
                        [:i.icon-tag.icon-white] " " g)))
    (apply column)))

(defpage "/" []
  (common/layout
    (splash)
    [:div.row
     (column (element-80p btn-large "manage-data" 
                          [:i.icon-list-alt.icon-white] " Manage merge fields")
             (element-80p btn-large "manage-groups" 
                          [:i.icon-tags.icon-white] " Manage snippet groups"))
     (snippet-groups-column)
     (column (element-80p btn-large-primary "compose-profile" 
                          [:i.icon-play-circle.icon-white] " Make a new profile"))]))
