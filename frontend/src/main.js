import { createApp } from 'vue'
import App from './App.vue'
import rouetr from './router'
import { createPinia} from 'pinia'

const app = createApp(App)
app.use(createPinia())
app.use(rouetr)
app.mount('#app')
