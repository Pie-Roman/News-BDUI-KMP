## News BDUI KMP

[![Static Badge](https://img.shields.io/badge/kotlin_multiplatform-purple)](https://kotlinlang.org/docs/multiplatform.html) [![Static Badge](https://img.shields.io/badge/divkit-orange)](https://github.com/divkit/divkit) [![Static Badge](https://img.shields.io/badge/ktor-gray)](https://ktor.io) [![Static Badge](https://img.shields.io/badge/kodein-purple)](https://kodein.net/oss.html) [![Static Badge](https://img.shields.io/badge/glide-blue)](https://github.com/bumptech/glide) [![Static Badge](https://img.shields.io/badge/coroutines-red)](https://kotlinlang.org/docs/coroutines-overview.html) [![Static Badge](https://img.shields.io/badge/android_fragments-green)](https://developer.android.com/guide/fragments) [![Static Badge](https://img.shields.io/badge/swift_uikit-blue)](https://developer.apple.com/documentation/uikit) [![Static Badge](https://img.shields.io/badge/cocoapods-red)](https://cocoapods.org)


Кроссплатформенное мобильное приложение по просмотру новостей News24, написанное на Kotlin Multiplatform и использующее Backend-driven UI на DivKit

[Figma](https://www.figma.com/design/syzUlOab6zEarNDqGbXfCh/Simple-News-UI-Kit-|-Developer-Practice-Kit-|-iPhone-13-(Community)?node-id=0-1&t=qkKZcpD4pt70r0BE-0)

### Введение

Данный проект разработан в рамках исследования преимуществ применения Backend-driven UI подхода совместно с Kotlin Multiplatform в разработке кроссплатформенных мобильных приложений.
- Backend-driven UI позволяет переносить значительную часть логики формирования вёрстки приложения на серверную часть
- Kotlin Multiplatform обеспечивает экономию ресурсов разработки за счет возможности писать общий код бизнес-логики один раз на несколько платформ

[Ссылка на репозиторий BDUI сервера](https://github.com/Pie-Roman/News-BDUI-Server)

Репозиторий данного проекта содержит:
- Код Android приложения
- Код IOS приложения
- Общий код domain и data слоев Android и IOS приложений

Засчет уединения кода бизнес-логики кодовая база проекта на Kotlin Multiplatform заметно меньше кодовой базы нижепредставленных проектов, взятых вместе

[Ссылка на репозиторий Android приложения (без использования Kotlin Multiplatform)](https://github.com/Pie-Roman/News-BDUI-Android)

[Ссылка на репозиторий IOS приложения (без использования Kotlin Multiplatform)](https://github.com/Pie-Roman/News-BDUI-Ios)

### Необходимые условия

- **Java Development Kit (JDK):** Рекомендуемая версия 8 или выше.
- **Gradle:** Версия 8.2 или выше.
- **DivKit:** Версия 29.15.0 или выше.
- **XCode:** Версия 15.3 или выше.
- **Ruby:** Версия 3.3.0 или выше.
- **CocoaPods**


### Начало работы

#### Клонирование репозитория

```sh
git clone https://github.com/Pie-Roman/News-BDUI-KMP
cd NewsBDUIKMP
```

#### Сборка и запуск

- Используйте Gradle для сборки проекта.

##### Android
- Откройте `androidApp`
- Запустите `MainActivity`

##### IOS
- Откройте `iosApp`
- Запустите `AppDelegate`

### Лицензия

Этот проект лицензирован под MIT License - смотрите файл [LICENSE](LICENSE) для деталей.