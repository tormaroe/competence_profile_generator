(ns CPG.views.cases
  (:require [CPG.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]))

(defpage "/manage-cases" []
  (common/layout
    [:div.row
     [:div.span12
      [:p "TODO"]]]))
