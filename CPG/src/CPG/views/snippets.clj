(ns CPG.views.snippets
  (:require [CPG.views.common :as common])
  (:require [CPG.models.textsnippets :as model])
  (:use [noir.core :only [defpage defpartial]]))

(defn snippets-list [group]
  [:table
    (->>
      (model/get-snippets-by-group group)
      (map (fn [snippet]
             [:tr
              [:td (:name snippet)]]))
      (cons :tbody)
      vec)])

(defpage "/snippetgroup/:group-key" {:keys [group-key]}
  (common/layout
    [:div.row
     [:div.span12
      [:h1 group-key " snippets"]
      [:div.pull-right
       [:a.btn.btn-primary {:href (str "/snippetgroup/"
                                       group-key
                                       "/new")} 
                           "Add a new snippet"]]
      (snippets-list group-key)]]))


(defpartial snippet-form [snippet]
  [:form.form-horizontal
   [:fieldset
    [:div.control-group
     [:label.control-label {:for "input-name"} "Name"]
     [:div.controls
      [:input.input-medium {:id "input-name"}]]]]
   [:textarea.editor]])

(defpage "/snippetgroup/:group-key/new" {:keys [group-key]}
  (common/layout
    [:div.row
     [:div.span12
      [:h1 "New " group-key " snippet"]
      [:hr]
      (snippet-form {})]]))
