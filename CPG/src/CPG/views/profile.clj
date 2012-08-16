(ns CPG.views.profile
  (:require [CPG.views.common :as common])
  (:use [noir.core :only [defpage defpartial]]))

(defpage "/compose-profile" []
  (common/layout
    [:div.row
     [:div.span12
      [:p "TODO"]]]))
