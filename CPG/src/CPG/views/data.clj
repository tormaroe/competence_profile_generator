(ns CPG.views.data
  (:require [CPG.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]))

(defpage "/manage-data" []
  (common/layout
    [:div.row
     [:div.span12
      [:p "TODO"]]]))
