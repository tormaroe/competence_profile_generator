(ns CPG.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]))

(def title "Competence Profile Generator")


(defpartial navbar []
  [:div.navbar.navbar-fixed-top
   [:div.navbar-inner
    [:div.container
     [:a.brand {:href "#"} title]
     [:ul.nav
      [:li [:a {:href "manage-data"} "Data"]]
      [:li [:a {:href "manage-people"} "People"]]
      [:li [:a {:href "manage-cases"} "Cases"]]
      [:li [:a {:href "compose-profile"} "Make new profile"]]]]]])

(defpartial layout [& content]
  (html5
    [:head
     [:title title]
     (include-css "/css/bootstrap.min.css")
     [:style {:type "text/css"} "body { padding-top: 60px; padding-bottom:40px; }"]
     (include-js "/js/bootstrap.min.js")]
    [:body
     (navbar)
     [:div.container
      content
      [:hr]
      [:footer
       [:p "&copy; Torbjørn Marø"]]]]))
