(ns CPG.views.snippets
  (:require [CPG.views.common :as common])
  (:require [CPG.models.textsnippets :as model])
  (:use [noir.core :only [defpage defpartial]]))

(defpage "/snippetgroup/:group-key" {:keys [group-key]}
  (common/layout
    [:div.row
     [:div.span12
      [:p group-key]]]))
