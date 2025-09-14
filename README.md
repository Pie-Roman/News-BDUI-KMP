# News BDUI KMP

[![Static Badge](https://img.shields.io/badge/kotlin_multiplatform-purple)](https://kotlinlang.org/docs/multiplatform.html) [![Static Badge](https://img.shields.io/badge/divkit-orange)](https://github.com/divkit/divkit) [![Static Badge](https://img.shields.io/badge/ktor-gray)](https://ktor.io) [![Static Badge](https://img.shields.io/badge/kodein-purple)](https://kodein.net/oss.html) [![Static Badge](https://img.shields.io/badge/glide-blue)](https://github.com/bumptech/glide) [![Static Badge](https://img.shields.io/badge/coroutines-red)](https://kotlinlang.org/docs/coroutines-overview.html) [![Static Badge](https://img.shields.io/badge/android_fragments-green)](https://developer.android.com/guide/fragments) [![Static Badge](https://img.shields.io/badge/swift_uikit-blue)](https://developer.apple.com/documentation/uikit) [![Static Badge](https://img.shields.io/badge/cocoapods-red)](https://cocoapods.org)

## Описание проекта

News-BDUI-KMP — это кроссплатформенное мобильное приложение для просмотра новостей, разработанное с использованием технологии Kotlin Multiplatform (KMP) в сочетании с подходом Backend-driven UI (BDUI). Проект демонстрирует преимущества совместного использования этих технологий для максимального уединения бизнес-логики, сокращения объема кодовой базы и снижения затрат ресурсов разработки.

## Особенности проекта

- **Kotlin Multiplatform**: Общая кодовая база для бизнес-логики, используемая как в Android, так и в iOS приложениях
- **Backend-driven UI**: Управление UI компонентами со стороны сервера, что позволяет обновлять интерфейс без выпуска новых версий приложения
- **Оптимизированная архитектура**: Четкое разделение на слои и модули с выносом общей логики в shared-модули
- **Сокращение дублирования кода**: Единая реализация бизнес-логики для обеих платформ
- **Ускоренный релизный цикл**: Возможность быстрого внедрения изменений без необходимости обновления приложений
- **Гибкость разработки**: Возможность использования нативных компонентов там, где это необходимо

## Архитектура

Проект построен с использованием многослойной архитектуры, где общая (common) кодовая база содержит бизнес-логику, а нативные части отвечают за UI-представление.

### Слои приложения:

1. **Presentation Layer (Слой представления)**
   - **ViewContract**: Определяет контракт в виде списка доступных команд, которые должна выполнять view
   - **Presenter**: Отвечает за логику вызова команд ViewContract и за взаимодействие с domain слоем

2. **Domain Layer (Слой бизнес-логики)**
   - **Usecase**: Представляет собой примитивное взаимодействие с данными
   - **Repository Interface**: Интерфейс хранилища данных, с которым взаимодействует Presenter через Usecase

3. **Data Layer (Слой данных)**
   - **Datasource**: Источник данных (сеть, кэш, локальная база данных)
   - **Repository Implementation**: Реализация репозитория, имеющая доступ к ряду источников данных

### Особенности архитектуры:

- **MVP паттерн**: Архитектура common части построена по принципу Model-View-Presenter
- **Бесшовная интеграция с Android**: KMP код интегрируется напрямую в Android-модули
- **iOS Framework**: Для iOS код KMP компилируется в единый iOS framework с Obj-C header файлами
- **Платформо-независимая бизнес-логика**: Domain и Data слои полностью вынесены в общую кодовую базу

## Функциональность

Приложение предоставляет следующие возможности:

1. **Просмотр последних новостей**
   - Вертикальный список карточек новостей
   - Данные получаются через BDUI сервер из API сервиса NewsData.io

2. **Поиск новостей**
   - Текстовое поле для ввода поискового запроса
   - Автоматический поиск через 0.5 секунды после последнего введенного символа
   - Отображение результатов поиска в виде вертикального списка карточек новостей

3. **Навигация между разделами**
   - Таббар с двумя вкладками: "Последние новости" и "Поиск"
   - Сохранение состояния вкладок при переключении

## Технологии и библиотеки

### Общие (Kotlin Multiplatform):
- **Kotlin Multiplatform**: Для создания общей кодовой базы
- **Kotlin Coroutines**: Для асинхронного программирования
- **Kotlinx Serialization**: Для сериализации/десериализации JSON
- **Ktor Client**: Для сетевых запросов
- **SQLDelight**: Для работы с базой данных (опционально)

### Android:
- **Android SDK**: Для разработки Android-приложения
- **DivKit**: Для реализации Backend-driven UI
- **Jetpack Components**: LiveData, ViewModel, Navigation

### iOS:
- **UIKit**: Для создания пользовательского интерфейса
- **DivKit iOS**: Для реализации Backend-driven UI
- **Combine**: Для реактивного программирования

## Структура проекта

```
News-BDUI-KMP/
├── androidApp/           # Android-приложение
│   ├── src/              # Исходный код Android-приложения
│   └── build.gradle      # Конфигурация сборки Android-приложения
├── iosApp/               # iOS-приложение
│   ├── iosApp/           # Исходный код iOS-приложения
│   └── iosApp.xcodeproj  # Проект Xcode
├── shared/               # Общий код для Android и iOS
│   ├── src/
│   │   ├── commonMain/    # Общий код для всех платформ
│   │   ├── androidMain/   # Код, специфичный для Android
│   │   └── iosMain/       # Код, специфичный для iOS
│   └── build.gradle.kts   # Конфигурация сборки общего модуля
└── build.gradle.kts       # Корневой файл конфигурации сборки
```

## Установка и запуск

### Предварительные требования:
- Android Studio Arctic Fox или новее
- Xcode 13 или новее
- JDK 11 или новее
- Kotlin Multiplatform Mobile plugin для Android Studio

### Запуск Android-приложения:
1. Клонировать репозиторий:
```
git clone https://github.com/Pie-Roman/News-BDUI-KMP.git
```
2. Открыть проект в Android Studio
3. Запустить BDUI сервер (см. репозиторий [News-BDUI-Server](https://github.com/Pie-Roman/News-BDUI-Server))
4. Выбрать конфигурацию запуска 'androidApp' и запустить приложение

### Запуск iOS-приложения:
1. Клонировать репозиторий (если еще не сделано)
2. Открыть проект в Android Studio
3. Запустить BDUI сервер (см. репозиторий [News-BDUI-Server](https://github.com/Pie-Roman/News-BDUI-Server))
4. Выбрать конфигурацию запуска 'iosApp' и запустить приложение
   
   Или:
   
   Открыть `iosApp/iosApp.xcodeproj` в Xcode и запустить проект

## Связь с другими проектами

Данный проект является частью исследования по использованию Backend-driven UI совместно с Kotlin Multiplatform в мобильной разработке и связан со следующими проектами:

- [News-BDUI-Android](https://github.com/Pie-Roman/News-BDUI-Android): Android-версия приложения с использованием только BDUI
- [News-BDUI-iOS](https://github.com/Pie-Roman/News-BDUI-Ios): iOS-версия приложения с использованием только BDUI
- [News-BDUI-Server](https://github.com/Pie-Roman/News-BDUI-Server): BDUI сервер для управления UI и данными

## Преимущества подхода BDUI + Kotlin Multiplatform

- **Сокращение объема кодовой базы**: Общая бизнес-логика для обеих платформ
- **Снижение затрат на разработку**: Меньше дублирования кода и усилий
- **Ускорение релизного цикла**: Быстрое внедрение изменений через BDUI
- **Единообразие поведения**: Одинаковая логика работы на разных платформах
- **Гибкость разработки**: Возможность использования нативных компонентов при необходимости
- **Масштабируемость**: Легкое добавление новых функций через общую кодовую базу
