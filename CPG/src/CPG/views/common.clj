(ns CPG.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]))

(def title "Competence Profile Generator")


(defpartial navbar []
  [:div.navbar.navbar-fixed-top
   [:div.navbar-inner
    [:div.container
     [:a.brand {:href "/"} title]
     [:ul.nav
      [:li [:a {:href "/manage-data"} [:i.icon-list-alt.icon-white] " Merge fields"]]
      [:li [:a {:href "/manage-groups"} [:i.icon-tags.icon-white] " Snippet groups"]]
      [:li [:a {:href "/compose-profile"} [:i.icon-play-circle.icon-white] " Make new profile"]]]]]])

(defpartial layout [& content]
  (html5
    [:head
     [:title title]
     (include-css "/css/bootstrap.min.css")
     [:style {:type "text/css"} "body { padding-top: 60px; padding-bottom:40px; }"]
     (include-js "/js/jquery.min.js")
     (include-js "/js/bootstrap.min.js")
     (include-js "/js/cpg.js")]
    [:body
     (navbar)
     [:div.container
      content
      [:hr]
      [:footer
       [:p "&copy; Torbjørn Marø"]]]]))
