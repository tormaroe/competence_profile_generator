(ns CPG.views.people
  (:require [CPG.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]))

(defpage "/manage-people" []
  (common/layout
    [:div.row
     [:div.span12
      [:p "TODO"]]]))
