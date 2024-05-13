Pod::Spec.new do |spec|
    spec.name                     = 'DivkitCustomFeature'
    spec.version                  = '1.0'
    spec.homepage                 = 'https://github.com/Pie-Roman/News-BDUI-KMP'
    spec.source                   = { :git => "local", :tag => "#{spec.version}" }
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'Divkit custom feature module'
    spec.ios.deployment_target = '12.0'
    spec.public_header_files = 'Sources/**/*.h'
    spec.source_files            = [
      'Sources/**/*.{swift,h,m}'
    ]

    spec.dependency 'BaseUiKit'
    spec.dependency 'CommonUmbrella'
    spec.dependency 'DivKit', '29.15.1'
    spec.dependency 'DivkitFeature'

    spec.dependency 'SearchFeature'
end
