(ns CPG.views.groups
  (:require [CPG.views.common :as common])
  (:require [CPG.models.textsnippets :as snippets])
  (:use [noir.core :only [defpage defpartial render]]))


(defpartial add-new-group-form []
  [:form {:action "/add-group"
          :method "POST"}
   [:input {:name :new-group}]
   [:input {:type :submit
            :value "Create"}]])

(defn delete-js [item]
  (str "window.document.cpg.deleteGroup('" item "');"))

(defpartial group-element [g]
  [:div.span3 {:style "background-color:#E6EFFF;
                      padding:5px;
                      padding-bottom:20px;
                      margin-top:10px;
                      margin-bottom:10px;
                      text-align:center;"} 
   [:h3 g]
   [:a.btn.btn-info.btn-mini {:href "#"} 
    [:i.icon-file.icon-white]
    " Snippets"]
   "&nbsp;"
   [:a.btn.btn-danger.btn-mini {:href "#"
                                :onclick (delete-js g)} 
    [:i.icon-trash.icon-white]
    " Delete"]])

(defpartial group-list []
  [:div (map group-element (snippets/groups))])

(defpage "/manage-groups" []
  (common/layout
    [:div.row
     [:div.span12
      [:h1 "Manage snippet groups"]
      [:p "These groups are the categories of snippets you can manage elsewhere. 
          Use this page to add or delete groups"]]]
    [:div.row
     [:div.span12
      (group-list)]]
    [:div.row
     [:div.span12
      [:h2 "Add a new group"]
      (add-new-group-form)]]))

(defpage [:post "/add-group"] {:as args}
  (snippets/add-group (:new-group args))
  (render "/manage-groups"))

(defpage [:post "/delete-group"] {:as args}
  (snippets/delete-group (:key args))
  (render "/manage-groups"))
