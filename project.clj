(defproject clj-antd-pro "0.1.0"
  :description "ant deisgn pro for clojurescript"
  :url "https://github.com/rainmote/clj-antd-pro"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.439"]
                 [cljsjs/ant-design-pro "2.1.1-0"]]
  :plugins [[lein-codox "0.10.3"]]
  :codox {:language :clojurescript
          :metadata {:doc/format :markdown}
          :output-path "doc/dist/latest/api"
          :namespaces [clj-antd-pro.core clj-antd-pro.reagent]})
