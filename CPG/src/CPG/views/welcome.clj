(ns CPG.views.welcome
  (:require [CPG.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]))


(defpartial splash []
  [:div.hero-unit
   [:h1 "Competence Profiles"]
   [:p "Manage your company competency profile with ease, and generate targeted profiles like a boss!"]])

(def btn-large          :a.btn.btn-large.btn-info)
(def btn-large-primary  :a.btn.btn-large.btn-primary)

(defpartial element-80p [elm href content]
  [elm {:href href :style "width:80%;"} content])

(defpartial column [& content]
  [:div.span3 {:style "text-align:center;"} content]) 

(defpage "/" []
  (common/layout
    (splash)
    [:div.row
     (column (element-80p btn-large "manage-data" "Manage key data values"))
     (column (element-80p btn-large "manage-people" "Manage people"))
     (column (element-80p btn-large "manage-cases" "Manage cases"))
     (column (element-80p btn-large-primary "compose-profile" "Make a new profile"))]))
