(ns clj-antd-pro.macros
  (:require [clojure.string :as s]
            [clj-antd-pro.antdpro :as antdpro]))

(def antdpro-module 'js/AntDesignPro)

(defn module-name->kebab-case
  "Converts module and sub module names from camel case to kebab case 
   eg: DatePicker to date-picker or Menu.Item to menu-item"
  [input]
  (->> (re-seq #"\w[a-z0-9]*" input)
       (map s/lower-case)
       (s/join "-")))

(def get-symbol-name (comp symbol module-name->kebab-case))

(defn get-module-path [module-name]
  (s/split module-name #"\."))

(defn define-fn [fn-name]
  (let [fn-name (name fn-name)]
    `(defn ~(get-symbol-name fn-name) [& args#]
       (apply clj-antd-pro.core/call-func ~fn-name args#))))

(defn define-prop [prop-name]
  (let [prop-name (name prop-name)]
    `(defn ~(get-symbol-name prop-name) [prop#]
       (clj-antd-pro.core/get-prop ~prop-name prop#))))

(defn define-form-funcs [method-name]
  (let [method-name (name method-name)]
    `(defn ~(get-symbol-name method-name) [form# & args#]
       (apply clj-antd-pro.core/call-js-func ((keyword ~method-name) form#) args#))))

(defn define-reagent-component [component]
  (let [component (name component)]
    `(def ~(get-symbol-name component)
       (reagent.core/adapt-react-class
        (apply goog.object/getValueByKeys 
               ~antdpro-module ~(get-module-path component))))))


(defmacro export-funcs []
  `(do ~@(map define-fn antdpro/funcs)))

(defmacro export-props []
  `(do ~@(map define-prop antdpro/props)))

(defmacro export-form-funcs []
  `(do ~@(map define-form-funcs antdpro/form-funcs)))

(defmacro export-reagent-components []
  `(do ~@(map define-reagent-component antdpro/components)))



