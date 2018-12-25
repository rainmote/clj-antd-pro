(ns antdpro-examples.reagent
  (:require [clojure.string :as string]
            [clj-antd-pro.reagent :as antdpro]
            [reagent.core :as r]))


(defn render-layout []
  (fn []
    [:div "test page"]
    [:div
     [antdpro/count-down {:style {:fontSize 30} :target 1545741042000}]]))

(defn init! []
  (r/render [render-layout]
    (js/document.getElementById "app")))
