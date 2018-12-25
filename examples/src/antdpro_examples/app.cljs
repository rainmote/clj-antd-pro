(ns antdpro-examples.app
  (:require [antdpro-examples.reagent :as reagent]))

(defn init! []
  (case js/example
    "reagent" (reagent/init!)))

(enable-console-print!)
(init!)
